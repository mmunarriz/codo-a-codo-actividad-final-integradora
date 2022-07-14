<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="title">Title</label>
        <input
          type="text"
          class="form-control"
          id="title"
          required
          v-model="club.title"
          name="title"
        />
      </div>

      <div class="form-group">
        <label for="description">Description</label>
        <input
          class="form-control"
          id="description"
          required
          v-model="club.description"
          name="description"
        />
      </div>

      <button @click="saveClub" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newClub">Add</button>
    </div>
  </div>
</template>

<script>
import ClubDataService from "../services/ClubDataService";

export default {
  name: "add-club",
  data() {
    return {
      club: {
        id: null,
        title: "",
        description: "",
        published: false
      },
      submitted: false
    };
  },
  methods: {
    saveClub() {
      var data = {
        title: this.club.title,
        description: this.club.description
      };

      ClubDataService.create(data)
        .then(response => {
          this.club.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newClub() {
      this.submitted = false;
      this.club = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>
