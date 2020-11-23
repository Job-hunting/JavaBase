package com.louis.tools;//package com.louis.tools;
//
//import java.lang.reflect.Method;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * Created by quguoqing on 2019-07-09.
// */
//public final class SortUtils {
//
//    private static final Logger LOG = LoggerFactory.getLogger(SortUtils.class);
//    public static final String ASC = "asc";
//    public static final String DESC = "desc";
//
//    private SortUtils() {
//        throw new IllegalStateException("SortUtils class");
//    }
//
//    public static <T> List<T> sort(List<T> targetList, String sortField, String sortMode) {
//        if (CollectionUtils.isEmpty(targetList) || StringUtils.isBlank(sortField) || StringUtils.isBlank(sortMode)) {
//            return targetList;
//        }
//        return targetList.stream().sorted((T o1, T o2) -> {
//            try {
//                Method method = ReflectionUtils.getGetterMethod(((T) o1).getClass(), sortField);
//                Comparable val1 = (Comparable) method.invoke(o1);
//                Comparable val2 = (Comparable) method.invoke(o2);
//                if (ASC.equals(sortMode)) {
//                    if (null == val1) {
//                        return -1;
//                    }
//                    if (null == val2) {
//                        return 1;
//                    }
//                    return val1.compareTo(val2);
//                } else if (DESC.equals(sortMode)) {
//                    if (null == val1) {
//                        return 1;
//                    }
//                    if (null == val2) {
//                        return -1;
//                    }
//                    return val2.compareTo(val1);
//                } else {
//                    return 0;
//                }
//            } catch (Exception e) {
//                LOG.error("sort by {} {} meet exception", sortField, sortMode, e);
//                return 0;
//            }
//        }).collect(Collectors.toList());
//    }
//}
