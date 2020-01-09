package com.gx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gx.po.KefangPo;

public interface KefangDao {
	
    /*public List<RoomSetPo> selectAll( );*/
	
	public int deleteById(Integer id);
	
	
	public int insertAll(KefangPo roomSetPo);
	
	
	public	KefangPo selectById(Integer id);

	
	public int updateById(KefangPo roomSetPo);
	
	//模糊查询
	/*public List<RoomSetPo> fuzzyselectPo(@Param("roomNumber")String roomNumber);*/
	
	
	//分页模糊查询
    public List<KefangPo> pageFuzzyselect(@Param("roomNumber")String roomNumber,@Param("start")int start,@Param("pageSize")int pageSize);
    
    //分页模糊查询总条数
    public int countFuzzyselect(String roomNumber);
    
    //查询全部
    public List<KefangPo> selectAll();
    
    //根据客房登记来查询
    public List<KefangPo> selectByLeveId(Integer id);
    
    //ajax 验证是否存在 此房间号
    public int selectYZ(String roomNumber);
    
    
    
    
    
    
    
    
    // 非本派所用  安排房间时 需要改变当前房间的房态
    public int updateByIdToRoomState(KefangPo roomSetPo);
    
    //非本派所用  查询房间信息
    public  List<KefangPo> selectInformation(String roomNumber);
    
    //非本派所用  客服等级来查询房间信息
    public  List<KefangPo> levelSelectInformation(Integer guestRoomLevelID);
    
    
}
