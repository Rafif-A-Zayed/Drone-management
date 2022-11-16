package com.drones.business;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BusinessServiceImpl <Req,Res > implements BusinessService <Req,Res > {



    public Res execute(Req request){
        try{
            validateRequest(request);
            return serviceLogic(request);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw e;
        }

    }

    void validateRequest(Req request){
     }


}
