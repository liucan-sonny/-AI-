<template>
  <el-card>
    <h3>{{ paperName }}</h3>
    <div v-for="item in questionList" :key="item.id" class="q-item">
      <p>{{ item.title }}</p>
      <el-radio-group v-model="answerMap[item.id]" v-if="item.type===1">
        <el-radio v-for="opt in JSON.parse(item.options)" :key="opt.key" :label="opt.key">
          {{ opt.val }}
        </el-radio>
      </el-radio-group>
      <el-input v-model="answerMap[item.id]" v-else-if="item.type===4" type="textarea" placeholder="输入简答答案"/>
    </div>
    <el-button type="primary" @click="submitExam">交卷</el-button>
  </el-card>
</template>
<script setup>
import {ref} from 'vue'
import axios from 'axios'
const paperName = ref('模拟试卷')
const questionList = ref([])
const answerMap = ref({})

// 加载试卷题目
const loadPaper = async ()=>{
  const res = await axios.get('/api/question/random',{
    params:{categoryId:1,type:1,level:1,num:5}
  })
  questionList.value = res.data
}
// 提交答卷
const submitExam = async ()=>{
  await axios.post('/api/answer/submit',{
    paperId:1,
    answerList: answerMap.value
  })
  alert("提交成功，AI正在判卷！")
}
loadPaper()
</script>
<style scoped>
.q-item{margin:16px 0;}
</style>
