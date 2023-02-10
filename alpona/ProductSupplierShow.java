
package alpona;

class ProductSupplierShow {
    public int pid;
    public String pname,pcat,supplier;
    public double cost;
    public ProductSupplierShow(int pid, String pname, String pcat){
        this.pid=pid;
        this.pname=pname;
        this.pcat= pcat;
    }
    public ProductSupplierShow(int pid,double cost, String pname, String pcat,String supplier){
        this.pid=pid;
        this.pname=pname;
        this.pcat= pcat;
        this.cost= cost;
        this.supplier= supplier;
    }
    public int getPid(){
        return pid;
    }
     public String getPname(){
        return pname;
    }
      public String getPcat(){
        return pcat;
    }
      public double getCost(){
          return cost;
      }
      public String getSupplier(){
          return supplier;
      }
}
