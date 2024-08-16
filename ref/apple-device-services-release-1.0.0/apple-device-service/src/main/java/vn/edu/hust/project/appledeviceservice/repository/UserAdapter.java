


package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.exception.CreateUserException;
import vn.edu.hust.project.appledeviceservice.exception.GetUserException;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IUserRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.UserModelMapper;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.GetUserSpecification;
import vn.edu.hust.project.appledeviceservice.utils.PageInfoUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserAdapter implements IUserPort {

    private final IUserRepository userRepository;

    @Override
    public UserEntity save(UserEntity entity) {
        try {
            return UserModelMapper.INSTANCE.toEntity(
                    userRepository.save(UserModelMapper.INSTANCE.toModel(entity))
            );
        } catch (Exception e) {
            log.error("[UserAdapter] Create user fail, err: " + e.getMessage());
            throw new CreateUserException();
        }
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        var userEntityOptional = userRepository.findByEmail(email);
        return userEntityOptional.map(UserModelMapper.INSTANCE::toEntity).orElse(null);
    }

    @Override
    public Pair<PageInfo, List<UserEntity>> getAllUsers(GetUserRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());
        var result = userRepository.findAll(new GetUserSpecification(filter), pageable);

        var pageInfo = PageInfoUtils.getPageInfoUtils(result);

        return Pair.of(pageInfo, UserModelMapper.INSTANCE.toEntities(result.getContent()));
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return UserModelMapper.INSTANCE.toEntity(userRepository.findById(userId).orElseThrow(
                () -> {
                    log.error("[UserAdapter] Get user by id fail, user id: " + userId);
                    throw new GetUserException();
                }
        ));
    }
}