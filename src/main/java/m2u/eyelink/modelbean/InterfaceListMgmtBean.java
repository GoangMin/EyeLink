package m2u.eyelink.modelbean;


import m2u.eyelink.util.Util;

public class InterfaceListMgmtBean
{
  private String InterfaceID;
  private String InterfaceName;
  private String ServiceName;
  private String InterfaceGroup;
  private String SourceSystem;
  private String SourceSystemType;
  private String TargetSystem;
  private String TargetSystemType;
  private String InterfaceType;
  private String MessagingType;
  private String InterfaceCycle;
  private String OwnerID;
  private String ObjectName;
  private String AttachedFileName;
  private String ActiveStatus;
  private String Remarks;
  private String RegisterTimestamp;
  private String UpdateTimestamp;
  
  public String getInterfaceID()
  {
    return Util.nulToStr(this.InterfaceID, "");
  }
  
  public void setInterfaceID(String paramString)
  {
    this.InterfaceID = paramString;
  }
  
  public String getInterfaceName()
  {
    return Util.nulToStr(this.InterfaceName, "");
  }
  
  public void setInterfaceName(String paramString)
  {
    this.InterfaceName = paramString;
  }
  
  public String getServiceName()
  {
    return Util.nulToStr(this.ServiceName, "");
  }
  
  public void setServiceName(String paramString)
  {
    this.ServiceName = paramString;
  }
  
  public String getInterfaceGroup()
  {
    return Util.nulToStr(this.InterfaceGroup, "");
  }
  
  public void setInterfaceGroup(String paramString)
  {
    this.InterfaceGroup = paramString;
  }
  
  public String getSourceSystem()
  {
    return Util.nulToStr(this.SourceSystem, "");
  }
  
  public void setSourceSystem(String paramString)
  {
    this.SourceSystem = paramString;
  }
  
  public String getSourceSystemType()
  {
    return Util.nulToStr(this.SourceSystemType, "");
  }
  
  public void setSourceSystemType(String paramString)
  {
    this.SourceSystemType = paramString;
  }
  
  public String getTargetSystem()
  {
    return Util.nulToStr(this.TargetSystem, "");
  }
  
  public void setTargetSystem(String paramString)
  {
    this.TargetSystem = paramString;
  }
  
  public String getTargetSystemType()
  {
    return Util.nulToStr(this.TargetSystemType, "");
  }
  
  public void setTargetSystemType(String paramString)
  {
    this.TargetSystemType = paramString;
  }
  
  public String getInterfaceType()
  {
    return Util.nulToStr(this.InterfaceType, "");
  }
  
  public void setInterfaceType(String paramString)
  {
    this.InterfaceType = paramString;
  }
  
  public String getMessagingType()
  {
    return Util.nulToStr(this.MessagingType, "");
  }
  
  public void setMessagingType(String paramString)
  {
    this.MessagingType = paramString;
  }
  
  public String getInterfaceCycle()
  {
    return Util.nulToStr(this.InterfaceCycle, "");
  }
  
  public void setInterfaceCycle(String paramString)
  {
    this.InterfaceCycle = paramString;
  }
  
  public String getOwnerID()
  {
    return Util.nulToStr(this.OwnerID, "");
  }
  
  public void setOwnerID(String paramString)
  {
    this.OwnerID = paramString;
  }
  
  public String getObjectName()
  {
    return Util.nulToStr(this.ObjectName, "");
  }
  
  public void setObjectName(String paramString)
  {
    this.ObjectName = paramString;
  }
  
  public String getAttachedFileName()
  {
    return Util.nulToStr(this.AttachedFileName, "");
  }
  
  public void setAttachedFileName(String paramString)
  {
    this.AttachedFileName = paramString;
  }
  
  public String getActiveStatus()
  {
    return Util.nulToStr(this.ActiveStatus, "");
  }
  
  public void setActiveStatus(String paramString)
  {
    this.ActiveStatus = paramString;
  }
  
  public String getRemarks()
  {
    return Util.nulToStr(this.Remarks, "");
  }
  
  public void setRemarks(String paramString)
  {
    this.Remarks = paramString;
  }
  
  public String getRegisterTimestamp()
  {
    return this.RegisterTimestamp;
  }
  
  public void setRegisterTimestamp(String paramString)
  {
    this.RegisterTimestamp = paramString;
  }
  
  public String getUpdateTimestamp()
  {
    return this.UpdateTimestamp;
  }
  
  public void setUpdateTimestamp(String paramString)
  {
    this.UpdateTimestamp = paramString;
  }
}
