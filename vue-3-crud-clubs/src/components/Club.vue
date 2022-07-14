<template>
  <div v-if="currentClub" class="edit-form">
    <h4>Club</h4>
    <form>
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title"
          v-model="currentClub.title"
        />
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description"
          v-model="currentClub.description"
        />
      </div>

      <div class="form-group">
        <label><strong>Status:</strong></label>
        {{ currentClub.published ? "Published" : "Pending" }}
      </div>
    </form>

    <button class="badge badge-primary mr-2"
      v-if="currentClub.published"
      @click="updatePublished(false)"
    >
      UnPublish
    </button>
    <button v-else class="badge badge-primary mr-2"
      @click="updatePublished(true)"
    >
      Publish
    </button>

    <button class="badge badge-danger mr-2"
      @click="deleteClub"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success"
      @click="updateClub"
    >
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Please click on a Club...</p>
  </div>
</template>

<script>
import ClubDataService from "../services/ClubDataService";

export default {
  name: "club",
  data() {
    return {
      currentClub: null,
      message: ''
    };
  },
  methods: {
    getClub(id) {
      ClubDataService.get(id)
        .then(response => {
          this.currentClub = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    updatePublished(status) {
      var data = {
        id: this.currentClub.id,
        title: this.currentClub.title,
        description: this.currentClub.description,
        published: status
      };

      ClubDataService.update(this.currentClub.id, data)
        .then(response => {
          console.log(response.data);
          this.currentClub.published = status;
          this.message = 'The status was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    updateClub() {
      ClubDataService.update(this.currentClub.id, this.currentClub)
        .then(response => {
          console.log(response.data);
          this.message = 'The club was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    deleteClub() {
      ClubDataService.delete(this.currentClub.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "clubs" });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.getClub(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>
