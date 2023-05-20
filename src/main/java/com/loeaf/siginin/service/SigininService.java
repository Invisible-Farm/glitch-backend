package com.loeaf.siginin.service;

import com.loeaf.siginin.dto.param.UserParam;
import com.loeaf.siginin.model.Account;

import java.lang.reflect.InvocationTargetException;

public interface SigininService {
    Account save(UserParam user) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;
    String signUp(UserParam user) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;
}
