package Singleton;

/**
 * @author linyabin
 * 6 枚举实现单例模式
 */
public enum SingletonEnum {
    INSTANCE;

    private String objName;

    public String getObjName(){
        return objName;
    }
    public void setObject(String objName){
        this.objName = objName;
    }

    public static void main(String[] args) {
        SingletonEnum firstInstance = SingletonEnum.INSTANCE;
        firstInstance.setObject("fistName");
        System.out.println(firstInstance.getObjName());
        SingletonEnum secondInstance = SingletonEnum.INSTANCE;
        secondInstance.setObject("secondName");
        System.out.println(firstInstance.getObjName());
        System.out.println(secondInstance.getObjName());

        // 反射获取实例测试
        try {
            SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
            for (SingletonEnum enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
