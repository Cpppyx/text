package com.example.springmvc_demo.service;

import com.example.springmvc_demo.pojo.NMW;

import java.util.List;

public interface NMVService {

    List<NMW> getnmvList();

    int addnmv(NMW nmw);

    boolean deleteNMV(int id);

    boolean updatenmv(NMW nmw);
    NMW selectNmvById(int id);
}
