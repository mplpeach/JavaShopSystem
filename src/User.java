public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void register() {
        //注册功能
        String username = "";
        String password = "";
        //用户名注册
        while (true){
            System.out.println("请输入用户名(长度不小于3位)：");
            username = Shop.sc.next();
            boolean flag = true;
            //判断用户是否存在
            for (User user : Shop.userList){
                if (username.equals(user.getUsername())){
                    System.out.println("用户名已存在");
                    flag = false;
                    break;
                }
            }
            if (!flag) continue;
            if (username.length() < 3){
                System.out.println("用户名不得小于三位！");
            }
            else break;
        }
        //密码注册
        while (true){
            System.out.println("请输入密码(需数字字母组合，长度不小于6位)：");
            password = Shop.sc.next();
            if (password.length() < 6){
                System.out.println("密码长度不能小于6位，请重新输入！");
                continue;
            }
            else if (!password.matches(".*[A-Za-z].*") || !password.matches(".*\\d.*")){
                System.out.println("密码必须同时包含字母与数字，请重新输入！");
                continue;
            }
            System.out.println("请再次确认密码");
            String repassword = Shop.sc.next();
            if (password.equals(repassword)){
                this.username = username;
                this.password = password;
                Shop.userList.add(this);
                System.out.println("注册成功！");
                break;
            }
            else {
                System.out.println("两次输入不一致，请重新输入！");
                continue;
            }
        }
    }
}
