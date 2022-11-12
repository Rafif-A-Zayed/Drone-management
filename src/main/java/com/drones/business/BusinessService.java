package com.drones.business;

public abstract class BusinessService <Req,Res>{


    public Res execute(Req request){

        validateRequest(request);

        Res response = serviceLogic(request);

        return response;
    }

    void validateRequest(Req request){

     };
    abstract Res serviceLogic(Req request);

}
