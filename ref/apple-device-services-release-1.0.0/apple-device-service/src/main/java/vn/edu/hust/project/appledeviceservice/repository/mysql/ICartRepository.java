package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.CartModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICartRepository extends IBaseRepository<CartModel> {
    List<CartModel> findByUserId(Long userId);

    Optional<CartModel> findByUserIdAndId(Long userId, Long productDetailId);

    Optional<CartModel> findByIdAndUserId(Long id, Long userId);

    Optional<CartModel> findByUserIdAndProductDetailId(Long userId, Long productDetailId);

    void deleteByIdIn(List<Long> cartIds);

    List<CartModel> findByIdIn(List<Long> cartIds);
}
