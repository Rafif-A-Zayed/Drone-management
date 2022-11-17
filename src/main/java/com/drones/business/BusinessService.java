package com.drones.business;


import org.springframework.transaction.annotation.Transactional;

public interface BusinessService  <Req,Res > {

    @Transactional
    Res execute(Req request);

    Res serviceLogic(Req request);

}
