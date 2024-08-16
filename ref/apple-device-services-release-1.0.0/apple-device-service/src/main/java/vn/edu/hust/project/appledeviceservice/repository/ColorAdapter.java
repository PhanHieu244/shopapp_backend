package vn.edu.hust.project.appledeviceservice.repository;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetColorRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.exception.CreateColorException;
import vn.edu.hust.project.appledeviceservice.exception.GetColorException;
import vn.edu.hust.project.appledeviceservice.exception.RemoveColorException;
import vn.edu.hust.project.appledeviceservice.port.IColorPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IColorRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.ColorModelMapper;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.ColorSpecification;
import vn.edu.hust.project.appledeviceservice.utils.PageInfoUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class ColorAdapter implements IColorPort {

    private final IColorRepository colorRepository;

    @Override
    public ColorEntity save(ColorEntity colorEntity) {
        try {
            var colorModel = colorRepository.save(ColorModelMapper.INSTANCE.toModel(colorEntity));

            return ColorModelMapper.INSTANCE.toEntity(colorModel);
        } catch (Exception ex) {
            log.error("[ColorAdapter] Create color fail, err: " + ex.getMessage());
            throw new CreateColorException();
        }

    }

    @Override
    public Pair<PageInfo, List<ColorEntity>> getAllColors(GetColorRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()),
            Math.toIntExact(filter.getPageSize()), Sort.by("id").descending());

        var result = colorRepository.findAll(
            new ColorSpecification(filter), pageable
        );
        var pageInfo = PageInfoUtils.getPageInfoUtils(result);
        return Pair.of(pageInfo, ColorModelMapper.INSTANCE.toEntities(result.getContent()));
    }

    @Override
    public ColorEntity getColorById(Long id) {
        var model = colorRepository.findById(id);
        if (model.isPresent()) {
            return ColorModelMapper.INSTANCE.toEntity(model.get());
        }
        throw new GetColorException();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteColorById(Long id) {
        try {
            colorRepository.deleteById(id);
        } catch (Exception ex) {
            log.error("[ColorAdapter] Delete color fail, err: " + ex.getMessage());
            throw new RemoveColorException();
        }

    }

    @Override
    public List<ColorEntity> findByIds(List<Long> ids) {
        return ColorModelMapper.INSTANCE.toEntities(colorRepository.findByIdIn(ids));
    }

}
