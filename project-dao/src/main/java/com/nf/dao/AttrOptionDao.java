package com.nf.dao;

import com.nf.entity.AttrOption;

public interface AttrOptionDao {
    /**
     * 添加属性选项
     * @param attrOption
     */
    void insertAttrOption(AttrOption attrOption);

    /**
     * 按照属性选项id 删除属性选项
     * @param optionId
     */
    void deleteAttrOption(Integer optionId);

    Integer getAttrOptionCount(Integer attrId);
}
