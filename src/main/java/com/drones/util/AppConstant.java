package com.drones.util;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class AppConstant {

    private AppConstant(){}

    public static String NOT_FOUND_MSG = "{0} not found";
    public static String INVALID_STATE_MSG = "{0} invalid state for that action";
    public static String MANDATORY_FIELD_MSG = "{0} mandatory field";
}
