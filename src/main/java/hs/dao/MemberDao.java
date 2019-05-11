package hs.dao;

import hs.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: huangshun
 * @Date: 2019/5/11 14:15
 * @Version 1.0
 */
@Repository("memberDao")
public interface MemberDao {

    /**
     * 根据id 查询会员信息
     * @param id
     * @return
     */
    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;


}
