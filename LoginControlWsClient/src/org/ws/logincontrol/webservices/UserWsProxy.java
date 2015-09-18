package org.ws.logincontrol.webservices;

public class UserWsProxy implements org.ws.logincontrol.webservices.UserWs {
  private String _endpoint = null;
  private org.ws.logincontrol.webservices.UserWs userWs = null;
  
  public UserWsProxy() {
    _initUserWsProxy();
  }
  
  public UserWsProxy(String endpoint) {
    _endpoint = endpoint;
    _initUserWsProxy();
  }
  
  private void _initUserWsProxy() {
    try {
      userWs = (new org.ws.logincontrol.webservices.UserWsServiceLocator()).getUserWsPort();
      if (userWs != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)userWs)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)userWs)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (userWs != null)
      ((javax.xml.rpc.Stub)userWs)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.ws.logincontrol.webservices.UserWs getUserWs() {
    if (userWs == null)
      _initUserWsProxy();
    return userWs;
  }
  
  public java.lang.String findUser(java.lang.String email, java.lang.String senha) throws java.rmi.RemoteException{
    if (userWs == null)
      _initUserWsProxy();
    return userWs.findUser(email, senha);
  }
  
  
}