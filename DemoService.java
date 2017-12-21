package com.dubbo.demo;

import java.util.List;

/**
 * Created by letrain on 2017/11/30.
 */
public interface DemoService {
    List<String> getPermissions(Long id);
}
