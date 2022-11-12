package com.drones.business;

public abstract class BusinessService <Req,Res>{


    public Res execute(Req request){

        validateRequest(request);

        return serviceLogic(request);

    }

    void validateRequest(Req request){
     }
    abstract Res serviceLogic(Req request);

}
