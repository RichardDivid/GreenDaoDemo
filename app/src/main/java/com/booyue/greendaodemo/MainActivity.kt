package com.booyue.greendaodemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.booyue.core.db.InstallBean
import com.booyue.core.db.greendao.InstallDao
import com.booyue.core.utils.LoggerUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var downloadDao = InstallDao.getInstance()//greendb 是下载操作类
        inset.setOnClickListener {
            var downloadBean = InstallBean()
            downloadBean.setAppId(100L)
            downloadBean.setOperation(100)
            downloadBean.setUserId("10000")
            downloadDao.insert(downloadBean)
        }
        delete.setOnClickListener {
            var list = downloadDao.query()
//            var deleteList:MutableList<DownloadBean> = mutableListOf()
            for (installBean in list) {
                if(installBean.userId == "100"){
                   downloadDao.delete(installBean)
                }
            }

//            downloadDao.delete(downloadBean)

        }
        update.setOnClickListener {
            var list = downloadDao.query()
            for (installBean in list) {
                installBean.userId = "000000000"
            downloadDao.update(installBean)
            }

        }
        query.setOnClickListener {
            var list = downloadDao.query()
            for (downloadBean in list) {
                LoggerUtils.d(TAG, "appId --${downloadBean.appId}: operation-- ${downloadBean.operation}  userId --${downloadBean.userId}");
            }
        }


    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        LoggerUtils.d(TAG, "has Focus: $hasFocus")
    }


    override fun onResume() {
        super.onResume()


    }

}
