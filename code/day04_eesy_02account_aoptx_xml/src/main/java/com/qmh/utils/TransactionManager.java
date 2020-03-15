package com.qmh.utils;

/**
 * 和事务管理相关的工具类 包含了开启事务，提交事务，回滚事务和释放事务
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try{
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 提交事务
     */
    public void commit(){
        try{
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try{
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 释放事务
     */
    public void release(){
        try{
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();//将线程与连接解绑
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
