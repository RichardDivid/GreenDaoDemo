#### 2019-4-23
    1、在project的build.gradle中引入 classpath 'org.greenrobot:greendao-gradle-plugin:3.2.1' // add plugin
    2、在app的build.gradle中添加
    apply plugin: 'org.greenrobot.greendao' // apply plugin
    在dependencies闭包中添加
    implementation 'org.greenrobot:greendao:3.2.0' // add library
    implementation 'org.greenrobot:greendao-generator:3.2.0'
    
    3、在app的build.gradle中添加升级代码
    greendao {
        //如果表更新 schemaVersion版本加1，创建临时表（结构与上一版本的表结构相同），
        //将旧数据移到临时表中，删除旧版本的表，创建新版本的表，将临时表中的数据转移到新表中，最后再删除临时表
        schemaVersion 1
        daoPackage 'com.booyue.core.db.greendao.gen'
        targetGenDir 'src/main/java'
    //    设置为true以自动生成单元测试
    //    generateTests false
        //targetGenDirTest：设置生成单元测试目录
        //generateTests：设置自动生成单元测试用例
    }
    