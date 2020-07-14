<template>
    <div class="Modal-inner">
      <el-dialog
        width="519px"
        :visible.sync="show"
        :before-close="handleClose"
        :close-on-click-modal="false"
        center>
        <h3 class="Modal-title">添加收藏</h3>
        <div class="Modal-subtitle">请选择你想添加的收藏夹</div>
        <div class="Modal-content">
          <div class="Favlists-content">
            <div class="Favlists-items" >
              <div class="Favlists-item"  v-for="(item,index) in favList" :key="index">
                <div class="Favlists-itemInner">
                  <div class="Favlists-itemName">
                    <span class="Favlists-itemNameText">{{item.favorites_name}}
                      <i class="el-icon-lock" v-if="!item.open"></i>
                    </span>
                  </div>
                  <div class="Favlists-itemContent">
                    <span class="Favlists-itemContent">{{item.collectCount}}条内容</span>
                  </div>
                </div>
                 <button type="button" @click="handleCollection(index)"  class="Button Favlists-updateButton Button--blue collect">
                   <span v-if="state[index]">已收藏</span>
                   <span v-if="!state[index]">收藏</span>
                 </button>
              </div>
            </div>
            <div class="Favlists-actions">
              <button type="button"  @click="openCreateCollectDialog" class="Button Favlists-addButton Button--primary Button--blue">创建收藏夹</button>
            </div>
          </div>
        </div>
      </el-dialog>

    </div>
</template>

<script>
import { setCollect, deleteCollect } from '../../api/attent.js'

export default {
  components: {
  },
  props: ['show', 'favList', 'quesId'],
  data () {
    return {
      userId: sessionStorage.getItem('userId'),
      state: []
    }
  },
  methods: {
    handleClose: function () {
      this.$emit('close')
    },
    // 处理收藏的状态变化
    handleCollection: function (index) {
      if (this.state[index] === undefined || this.state[index] === false) {
        this.state[index] = true
        console.log('收藏', this.state[index])
        console.log('QUESTID', this.quesId)
        //  console.log(this.userId);
        //  console.log(this.favList[index].favorites_id);
        let params = {
          userId: this.userId,
          favoritesId: this.favList[index].favorites_id,
          quesId: this.quesId
        }
        setCollect(params).then(res => {
          if (res.resultCode === 200) {
            this.testList = res.data
            this.favList[index].collectCount = this.favList[index].collectCount + 1
            alert('收藏成功！')
          }
        })
      } else {
        this.state[index] = !this.state[index]
        console.log('取消收藏', this.state[index])
        let params = {
          userId: this.userId,
          favoritesId: this.favList[index].favorites_id,
          quesId: this.quesId
        }
        deleteCollect(params).then(res => {
          if (res.resultCode === 200) {
            this.testList = res.data
          }
          if (this.favList[index].collectCount !== 0) {
            this.favList[index].collectCount = this.favList[index].collectCount - 1
            alert('取消收藏成功！')
          }
        })
      }
      // this.favList[index].collectState = ! this.favList[index].collectState;
    },

    openCreateCollectDialog: function () {
      this.$emit('openCreateCollectDialog')
    }
  }

}
</script>

<style scoped>
.Modal-inner {
    overflow: auto;
    background: #fff;
    border-radius: 2px;
}
.Modal-title {
    font-size: 24px;
    font-weight: 500;
    color: #1a1a1a;
    text-align: center;
}
h1, h2, h3 {
    margin: 0;
    font: inherit;
}
.Modal-subtitle {
    padding: 0 38px;
    margin-top: 4px;
    font-size: 14px;
    line-height: 1.5;
    color: #8590a6;
    text-align: center;
}
.Modal-content {
    -webkit-box-flex: 1;
    flex: 1 1;
    padding: 0 24px 32px;
    margin-top: 24px;
    line-height: 1.7;
    opacity: 1;
}
.Favlists-items {
    max-height: 335px;
    min-height: 140px;
    margin-bottom: 40px;
    overflow-x: hidden;
    overflow-y: auto;
}
.Favlists-item {
    display: flex;
    -webkit-box-pack: justify;
    justify-content: space-between;
    -webkit-box-align: center;
    align-items: center;
    padding: 8px 0;
    border-bottom: 1px solid #ebebeb;
}
.Favlists-itemInner {
    overflow: hidden;
    margin-right: 20px;
}
.Favlists-itemName {
    display: flex;
    overflow: hidden;
    text-overflow: ellipsis;
}
.Favlists-itemNameText {
    overflow: hidden;
    font-weight: 700;
    text-overflow: ellipsis;
    white-space: nowrap;
}
.Favlists-itemContent {
    font-size: 14px;
    color: #8590a6;
    margin-top: 4px;
}
.Favlists-actions, .Favlists-mobileActions {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}
.Favlists-updateButton {
    padding-left: 0;
    padding-right: 0;
    width: 76px;
    -ms-flex-negative: 0;
    flex-shrink: 0;
}
.Button--primary.Button--blue {
    color: #fff;
    background-color: #0084ff;
}
.Favlists-addButton {
    width: 220px;
}
.Button--blue {
    color: #0084ff;
    border-color: #0084ff;
}.Button {
    display: inline-block;
    padding: 0 16px;
    font-size: 14px;
    line-height: 32px;
    color: #8590a6;
    text-align: center;
    cursor: pointer;
    background: none;
    border: 1px solid;
    border-radius: 3px;
}
.collect{
  border-color: #0084ff;
  color: #0084ff;
}

</style>
