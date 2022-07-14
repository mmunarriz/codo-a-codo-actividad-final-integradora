<template>
  <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by title"
          v-model="title"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
            @click="searchTitle"
          >
            Search
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <h4>Clubs List</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(club, index) in clubs"
          :key="index"
          @click="setActiveClub(club, index)"
        >
          {{ club.title }}
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllClubs">
        Remove All
      </button>
    </div>
    <div class="col-md-6">
      <div v-if="currentClub">
        <h4>Club</h4>
        <div>
          <label><strong>Title:</strong></label> {{ currentClub.title }}
        </div>
        <div>
          <label><strong>Description:</strong></label> {{ currentClub.description }}
        </div>
        <div>
          <label><strong>Status:</strong></label> {{ currentClub.published ? "Published" : "Pending" }}
        </div>

        <router-link :to="'/clubs/' + currentClub.id" class="badge badge-warning">Edit</router-link>
      </div>
      <div v-else>
        <br />
        <p>Please click on a Club...</p>
      </div>
    </div>
  </div>
</template>

<script>
import ClubDataService from "../services/ClubDataService";

export default {
  name: "clubs-list",
  data() {
    return {
      clubs: [],
      currentClub: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveClubs() {
      ClubDataService.getAll()
        .then(response => {
          this.clubs = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveClubs();
      this.currentClub = null;
      this.currentIndex = -1;
    },

    setActiveClub(club, index) {
      this.currentClub = club;
      this.currentIndex = club ? index : -1;
    },

    removeAllClubs() {
      ClubDataService.deleteAll()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    searchTitle() {
      ClubDataService.findByTitle(this.title)
        .then(response => {
          this.clubs = response.data;
          this.setActiveClub(null);
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveClubs();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>
