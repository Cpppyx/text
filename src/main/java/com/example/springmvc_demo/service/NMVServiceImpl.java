package com.example.springmvc_demo.service;

import com.example.springmvc_demo.mapper.NMWMapper;
import com.example.springmvc_demo.pojo.NMW;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NMVServiceImpl implements NMVService{
    @Resource
    NMWMapper nMWMapper;

    @Override
    public List<NMW> getnmvList() {
        return nMWMapper.getnmvList();
    }

    @Override
    public int addnmv(NMW nmw) {
        return nMWMapper.addnmv(nmw);
    }

    @Override
    public boolean deleteNMV(int id) {
        return nMWMapper.deleteNMV(id);
    }

    @Override
    public boolean updatenmv(NMW nmw) {
        return nMWMapper.updatenmv(nmw);
    }

    @Override
    public NMW selectNmvById(int id) {
        return nMWMapper.selectNmvById(id);
    }
}
