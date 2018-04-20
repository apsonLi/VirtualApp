package com.lody.virtual.server.interfaces;

import android.content.ClipData;
import android.os.RemoteException;

/**
 * Created by 葛垚 on 2018/4/14.
 */

public interface IAppPermissionManager extends IPCInterface {
    /**
     * 是否是支持的权限
     *
     * @param permissionName 权限名称
     * @return 是否是支持的权限
     */
    boolean isSupportPermission(String permissionName) throws RemoteException;

    /**
     * 清除权限数据
     */
    void clearPermissionData() throws RemoteException;

    /**
     * 设置应用权限开关
     *
     * @param packageName      应用包名
     * @param permissionName   权限名称
     * @param isPermissionOpen 开关状态
     */
    void setAppPermission(String packageName, String permissionName, boolean isPermissionOpen) throws RemoteException;

    /**
     * 获取应用权限开关状态
     *
     * @param packageName    应用包名
     * @param permissionName 权限名称
     * @return 应用权限开关状态
     */
    boolean getAppPermissionEnable(String packageName, String permissionName) throws RemoteException;

    /**
     * 注册监听
     *
     * @param iAppPermissionCallback 监听
     */
    void registerCallback(IAppPermissionCallback iAppPermissionCallback) throws RemoteException;

    /**
     * 解除监听注册
     */
    void unregisterCallback() throws RemoteException;

    /**
     * 权限拦截触发回调
     *
     * @param appPackageName 应用包名
     * @param permissionName 权限名称
     */
    void interceptorTriggerCallback(String appPackageName, String permissionName) throws RemoteException;

    /**
     * 缓存剪切板信息
     *
     * @param clipData 剪切板信息
     */
    void cacheClipData(ClipData clipData) throws RemoteException;

    /**
     * 获取剪切板信息
     *
     * @return 剪切板信息
     */
    ClipData getClipData() throws RemoteException;

    abstract class Stub implements IAppPermissionManager {
        @Override
        public boolean isBinderAlive() {
            return false;
        }

        @Override
        public boolean pingBinder() {
            return false;
        }
    }
}