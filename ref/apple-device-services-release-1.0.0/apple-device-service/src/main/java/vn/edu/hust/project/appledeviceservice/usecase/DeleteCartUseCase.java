package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import vn.edu.hust.project.appledeviceservice.exception.DeleteCartException;
import vn.edu.hust.project.appledeviceservice.port.ICartPort;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteCartUseCase {
    private final ICartPort cartPort;

    public void deleteCart(Long cartId, Long userId) {
        var cart = cartPort.getCartByIdAndUserId(cartId, userId);
        if (ObjectUtils.isEmpty(cart)) {
            log.error("[DeleteCartUseCase] Cart not found");
            throw new DeleteCartException();
        }
        cartPort.deleteCart(cartId);
    }

    public void deleteCartByIds(List<Long> cartIds) {
        cartPort.deleteCartByIds(cartIds);
    }
}
