package org.example.hw8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ServiceImpl implements Service, Serializable {

    private List<String> list;
    {
        list = new ArrayList<>();
    }

    @Override
    public List<String> run(String item, double value, LocalDate date) {
//        CacheType cacheType = null;
//        String filenamePrefix = null;
//        boolean zip = false;
//        Class<?>[] classes = new Class[0];
//        long lists = 0;
//
//        list.add(item);
//        if(list.contains(item)){
//            //todo если уже считали
//        }
//        double result = doHardWork(value);
//
//        try {
//            Cache annotation = this.getClass().getMethod("run").getAnnotation(Cache.class);
//            cacheType = annotation.cacheType();
//            filenamePrefix = Objects.equals(annotation.fileNamePrefix(), "") ? "run" : annotation.fileNamePrefix();
//            zip = annotation.zip();
//            classes = annotation.identityBy();
//            lists = annotation.listList();
//        }catch (NoSuchMethodException e){
//            System.out.println(e.getMessage());
//        }
//        if(cacheType == CacheType.FILE){
//            cacheToFile(filenamePrefix, zip, classes, result);
//        }else{
//            cacheToMemory(lists, result);
//        }
//
//        return result;
        List<String> result = new ArrayList<>();
        result.add(item + "_" + value + "_" + date.toString());
        return result;
    }

    private void cacheToFile(String pathPrefix, boolean zip, Class<?>[] classes, double result){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(pathPrefix+"\\save.ru"))){
            outputStream.writeObject(this);
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    private void cacheToMemory(long lists, double result){

    }

    private double doHardWork(double value){
        return Math.pow(value, 10);
    }

    @Override
    public List<String> work(String item) {
        List<String> res = new ArrayList<>();
        res.add(item);
        return res;
    }
}
