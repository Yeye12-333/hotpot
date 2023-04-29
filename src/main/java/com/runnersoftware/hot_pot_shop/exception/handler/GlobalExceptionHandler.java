package com.runnersoftware.hot_pot_shop.exception.handler;

import com.runnersoftware.hot_pot_shop.exception.HotPotException;
import com.runnersoftware.hot_pot_shop.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HotPotException.class)
    public R exceptionHandler(HotPotException hotPotException){
        hotPotException.printStackTrace();
        return R.error().message(hotPotException.getMessage());
    }

}
