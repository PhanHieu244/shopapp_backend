package vn.edu.hust.project.appledeviceservice.repository.mysql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequestWeb;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductDetailModel;

import java.util.List;

@Service
public class CustomProductDetailImpl implements ICustomProductDetailRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<ProductDetailModel> getAllProductDetails(GetProductDetailRequestWeb filter) {
        var rawQuery = buildRawQuery(filter);
        var query = entityManager.createNativeQuery(rawQuery, ProductDetailModel.class);
        return query.getResultList();
    }

    private String buildRawQuery(GetProductDetailRequestWeb filter) {
        var rawQuery =  "SELECT * FROM product_details pd\n" +
                "WHERE pd.id IN (\n" +
                "    SELECT max_product_detail_id FROM (\n" +
                "                                          SELECT pd.product_id, pd.id as max_product_detail_id, inventories.id,\n" +
                "                                                 RANK() OVER (PARTITION BY pd.product_id ORDER BY inventories.sold DESC) as `rank`\n" +
                "                                          FROM product_details pd JOIN inventories ON inventories.product_detail_id = pd.id\n" +
                "                                                                  JOIN products p ON pd.product_id = p.id\n" +
                "                                                                  JOIN types t ON p.type_id = t.id\n" +
                "                                          WHERE inventories.available > 0 AND p.status = 'ACTIVE'\n";

        if (filter.getType() != null) {
            rawQuery += " AND t.code = '" + filter.getType() + "'\n";
        }

        rawQuery += "                                      ) as max_product_detail\n" +
                "    WHERE `rank` = 1\n" +
                ")";

        return rawQuery;
    }
}
