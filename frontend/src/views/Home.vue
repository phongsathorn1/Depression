<template>
  <div class="container p-3">
    <div class="row d-flex align-items-stretch">
      <div class="col-sm-12 col-lg-8">
        <h1>แบบประเมินโรคซึมเศร้า</h1>
        <div v-for="q in questions" :key="q.questionID">
          <b-form-group :label="q.questionTitle">
            <b-form-radio-group
              v-model="
                answers.answers.find(e => e.questionID == q.questionID)
                  .selectedChoice
              "
            >
              <b-form-radio
                v-for="c in q.choices"
                :key="c.choiceID"
                :value="c.choiceValue"
                >{{ c.choiceTitle }}</b-form-radio
              >
            </b-form-radio-group>
          </b-form-group>
          <hr />
        </div>
      </div>

      <div class="col-sm-12 col-lg-4">
        <div class="sticky-top">
          <b-button
            variant="primary"
            :disabled="isDisabled"
            @click.prevent="getInterpretation"
            >ประมวลผล</b-button
          >
          <div v-if="interpretation">
            <h3>คะแนนรวม: {{ interpretation.totalScore }}</h3>
            <h2>{{ interpretation.depressionSeverity }}</h2>
          </div>
        </div>
      </div>

      <!-- ตรงนี้พีทำ จะเป็นส่วนของแสดงคำแนะนำ -->
      <div class="col-sm-12 col-lg-4">
        <div class="sticky-top">
          <div v-if="suggestions">
            <h3>คำแนะนำ: {{ suggestions.text }}</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: "home",
  data() {
    return {
      questions: [],
      answers: {
        answers: [
          {
            questionID: 1,
            selectedChoice: null,
          },
          {
            questionID: 2,
            selectedChoice: null,
          },
          {
            questionID: 3,
            selectedChoice: null,
          },
          {
            questionID: 4,
            selectedChoice: null,
          },
          {
            questionID: 5,
            selectedChoice: null,
          },
          {
            questionID: 6,
            selectedChoice: null,
          },
          {
            questionID: 7,
            selectedChoice: null,
          },
          {
            questionID: 8,
            selectedChoice: null,
          },
          {
            questionID: 9,
            selectedChoice: null,
          },
        ],
      },
      interpretation: null,
      suggestions: null,
    };
  },
  mounted() {
    let self = this;

    this.axios.get("http://35.247.175.250:8080/questions").then(response => {
      console.log(response.data);
      self.questions = response.data;
    });
  },
  methods: {
    getInterpretation() {
      let self = this;
      this.axios
        .post("http://35.247.175.250:8080/interpretation", this.answers)
        .then((response) => {
          self.interpretation = response.data;
          this.getSuggestion();
        })
        .catch(function(error) {
          self.interpretation = error;
        });
      // console.log(this.interpretation);
    },
    getSuggestion() {
      let self = this;
      console.log("suggest");
      this.axios
        .get(
          "http://34.69.92.81/suggest/suggestion/" + this.interpretation.totalScore
        )
        .then(response => {
          console.log(response.data);
          self.suggestions = response.data;
        });
      console.log(this.suggestions);
    }
  },
  computed: {
    isDisabled() {
      let flag = false;

      this.answers.answers.forEach(e => {
        if (e.selectedChoice == null) {
          flag = true;
        }
      });

      return flag;
    },
  },
};
</script>

<style scoped></style>
