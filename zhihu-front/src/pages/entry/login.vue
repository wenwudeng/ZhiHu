<template>
  <div id="signinFrame">
    <div id="signheader">
      <div id="iconZhihuLogo">
        <img id="logonimg" alt="loog" src="../../assets/zhihulogo.png"/>
        <div id="headeInfo">
          登陆知乎，发现更多可信赖的解答
        </div>
      </div>

      <div class="login-content">
        <el-form >
          <el-form-item>
            <el-row class="formstyle">
              <el-col :span="20" style="margin-top: 30px;">
                <el-input v-model="username" @blur="checkout"   placeholder="手机或邮箱号" clearable></el-input>
               <div v-if="username===''" style="height: 10px;color: red;margin-top: -10px;font-size: 3px">{{uInput}}</div>
                <el-input v-model="password" @blur="checkout1" placeholder="请输入密码" show-password style="margin-top: 20px;"></el-input>
                <div v-if="password===''" style="height: 10px;color: red;margin-top: -10px;font-size: 3px">{{pInput}}</div>
              </el-col>
            </el-row>
          </el-form-item>

          <el-form-item>
            <el-row >
              <el-col :span="15" class="formstyle">
                <el-input v-model="inputCode" maxlength="4"   placeholder="请输入验证码" style="width: 150px;margin-top: 30px"
                          @blur="checkNum"></el-input>
                <div class="divIdentifyingCode">
                  <el-button type="text" style="margin-left: -30px;font-size: 20px;margin-top: 20px" @click="createCode">{{showCode}}</el-button>
                 <!-- <span type="text" v-if="inputCode!==showCode"   style="color: red;margin-left: 10px;font-size: 5px">{{ tip }}</span>-->
                </div>
              </el-col>
              <el-col :span="20">
                <el-button type="primary" @click="onSubmit"
                           style="width: 85%;text-align: center;background-color:#409EFF;margin-left: 70px;margin-top: 20px ">登陆
                </el-button>
              </el-col>
            </el-row>
          </el-form-item >
        </el-form>
      </div>
      <div id="switch">
        <p>没有账号？
          <router-link to="/Register" style="text-decoration: none">
            <el-button type="text" style="color:#409EFF">注册</el-button>
          </router-link>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import { reqLogin } from '../../api/login.js'
import { ERR_OK } from '../../api/config.js'
import md5 from 'js-md5'
export default {
  data () {
    return {
      'username': '',
      'password': '',
      'inputCode': '',
      'showCode': '7Q1Y',
      'tip': '',
      'uInput': '',
      'pInput': ''
    }
  },
  methods: {
    onSubmit () {
      let params = {
        account: this.username,
        password: md5(this.password)
      }
      reqLogin(params).then(res => {
        if (this.username === '' && this.password === '' && this.inputCode === '') {
          alert('请填入完整的信息')
        } else {
          if (this.inputCode === '') {
            alert('请输入验证码')
          } else {
            if (this.inputCode.toUpperCase() !== this.showCode) {
              alert('请输入正确的验证码')
            } else {
              if (res.resultCode === ERR_OK) {
                console.log(res)
                console.log('哇哦', sessionStorage.getItem('imagUrl'))
                var returnInfo = res.resultMessage
                if (returnInfo === '账号密码正确，允许登陆') {
                  var userId = res.data.user_id
                  console.log(userId)
                  console.log(res.data)
                  var userName = res.data.name
                  // 点赞次数
                  var praiseNum = res.data.praise_number
                  // 关注人数
                  var attentNum = res.data.attention_number
                  // 粉丝数量
                  var followNum = res.data.follower_number
                  // 关注话题数
                  var topicNum = res.data.concern_topic_number
                  // 头像
                  var imagUrl = res.data.portrait
                  sessionStorage.setItem('userId', userId)
                  sessionStorage.setItem('userName', userName)
                  sessionStorage.setItem('praiseNum', praiseNum)
                  sessionStorage.setItem('attentNum', attentNum)
                  sessionStorage.setItem('followNum', followNum)
                  sessionStorage.setItem('topicNum', topicNum)
                  sessionStorage.setItem('imagUrl', imagUrl)
                  this.$router.push({ 'path': '/Home/index' })
                } else if (returnInfo === '账户不存在') {
                  alert('账户不存在')
                } else if (returnInfo === '密码不正确') {
                  alert('密码错误')
                }
              }
            }
          }
        }
      }
      )
    },
    createCode () {
      var code = ''
      var codeLength = 4
      var random = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
      for (var i = 0; i < codeLength; i++) {
        // 循环操作
        var index = Math.floor(Math.random() * 36)// 取得随机数的索引（0~35）
        code += random[index]// 根据索引取得随机数加到code上
      }
      this.showCode = code// 把code值赋给验证码
    },
    checkNum () {
      var num = this.inputCode.toUpperCase()
      if (num === this.showCode) {
        this.tip = ''
      } else if (num === '') {
        this.tip = '验证码不能为空'
      } else {
        this.tip = '*验证码错误'
        this.createCode()
      }
    },
    created () {
      this.created()
    },
    checkout () {
      if (this.username === '') {
        this.uInput = '*账号不能为空'
      }
    },
    checkout1 () {
      if (this.password === '') {
        this.pInput = '*密码不能为空'
      }
    }
  }

}
</script>

<style scoped>
  #signinFrame {
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
.el-row{
  height:70px;
}
.el-col{
  height:70px;
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

  .login-content {
    height: 300px;
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

  .divIdentifyingCode {
    position: absolute;
    top: 0;
    margin-top: 10px;
    margin-left: 200px;
    z-index: 5;
    width: 102px; /*设置图片显示的宽*/
    height: 10px; /*图片显示的高*/
    background: white;
  }
</style>
