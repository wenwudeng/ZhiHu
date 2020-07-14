<template>
  <div id="signupFrame">
    <div id="signheader">
      <div id="iconZhihuLogo">
        <img id="logonimg" alt="loog" src="../../assets/zhihulogo.png"/>
        <div id="headeInfo">
          注册知乎，发现更多可信赖的解答
        </div>
      </div>
      <div class="rig-content">
        <el-form>
          <span style="color: red;margin-left: 60px;margin-top: 40px" v-if="username === '' || password === '' ">{{tip}}</span>
          <span style="color: red;margin-left: 60px;margin-top: 40px">{{returnTips}}</span>
          <el-form-item >
            <el-row class="formstyle">
              <el-col :span="20" style="margin-top: 30px;">
                <el-input v-model="username" placeholder="请输入手机号|邮箱" clearable></el-input>
                <el-input v-model="password" placeholder="请输入密码" show-password style="margin-top: 20px;"></el-input>
              </el-col>
              <el-col :span="20" style="margin-top: 70px">
                <el-button type="primary" @click="onSubmit" style="width: 100%;text-align: center;background-color:#409EFF ">注册</el-button>
              </el-col>
            </el-row>
          </el-form-item>
        </el-form>
      </div>
      <div id="switch">
        <p>已有账号？
          <router-link to="/Login" style="text-decoration: none">
            <el-button type="text" style="color:#409EFF">登陆</el-button>
          </router-link>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import { reqRegister } from '../../api/register'
import { ERR_OK } from '../../api/config'
import md5 from 'js-md5'
export default {
  data () {
    return {
      password: '',
      username: '',
      tip: '',
      returnTips: ''
    }
  },
  methods: {
    onSubmit () {
      let params = {
        account: this.username,
        password: md5(this.password)
      }
      reqRegister(params).then(res => {
        if (this.username === '' || this.password === '') {
          this.tip = '*请输入完整的信息'
          return false
        }
        if (res.resultCode === ERR_OK) {
          console.log('data', res)
          var returnInfo = res.resultMessage
          if (returnInfo === '手机号已被注册') {
            this.returnTips = '*该账号已被注册'
          } else if (returnInfo === '请输入正确的手机号') {
            this.returnTips = '*请输入正确的手机号'
          } else {
            alert('注册成功')
            this.$router.push({ path: '/Login' })
          }
        }
      })
    }
  }
}
</script>

<style scoped>
  #signupFrame{
    height: 100%;
    width: 100%;
    background-color: #b8e5f8;
    background-image: url("../../assets/background.png");
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment: fixed;
    position: fixed;
    margin-left: -8px;
    margin-top: -8px;
  }
  #signheader {
    width: 430px;
    height: 143px;
    background-color: white;
    margin: 0 auto;
    margin-top: 70px;
  }

  #logonimg {
    margin-left: 110px;
  }

  #headeInfo {
    color: #0084ff;
    font-size: 22px;
    margin-top: 10px;
    margin-left: 50px;
  }

  .rig-content {
    height: 283px;
    background-color: white;
  }

  #switch {
    height: 59px;
    background-color: #f6f6f6;
    text-align: center;
    border-top: 1px solid #ebebeb;
    font-size: 16px;
    margin-top: -30px;
  }

  .formstyle {
    margin-left: 70px;
  }

</style>
