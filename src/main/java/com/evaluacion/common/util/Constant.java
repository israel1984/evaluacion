package com.evaluacion.common.util;

public final class Constant {

    
    public static final String NEW_LINE		      = System.getProperty("line.separator");
    public static final String URL_LABEL	      = "[URL]: ";
    public static final String REQUEST_METHOD_LABEL   = "[Request Method]: ";
    public static final String CONTROLLER_LABEL	      = "[Controller]: ";
    public static final String CLASS_LOG_LABEL	      = "[Class]: ";
    public static final String METHOD_LOG_LABEL	      = "[Method]: ";
    public static final String PARAMETERS_LOG_LABEL   = "(...)";
    public static final String INPUT_PARAMETERS_LABEL = "[Input Params]: ";
    public static final String INPUT_PARAMETER_LABEL  = "[Input]: ";
    public static final String OUTPUT_LABEL	      = "[Output]: ";
    public static final String SEPARATOR	      = "===================================================================================================================================================================================";
    public static final String EXCEPTION_WAS_THROWN   = "-> An exception was thrown by method: ";
    public static final String PARSE_JSON_RESPONSE    = "[It couldn't parse to JSON the method's response (Please check the log)]";
    public static final String DEV_ENVIRONMENT	      = "dev";
    public static final String PROD_ENVIRONMENT	      = "prod";


    /** date format **/
    public static final String TIME = "HH:mm:ss";
    public static final String DATE = "dd/MM/yy";
    
    
    private Constant() {
    }
}
