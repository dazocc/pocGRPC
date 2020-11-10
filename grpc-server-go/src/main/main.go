package main

import (
	"encoding/json"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

type Person struct {
	id    int    `json:"id,omitempty"`
	nome  string `json:"firstname,omitempty"`
	login string `json:"lastname,omitempty"`
	cpf   string `json:"lastname,omitempty"`
	email string `json:"lastname,omitempty"`
}

func getId() func() int {
	var id int
	return func() int {
		id++
		return id
	}
}

func CreatePerson(w http.ResponseWriter, r *http.Request) {
	var person Person
	_ = json.NewDecoder(r.Body).Decode(&person)
	vair idadsf = getId()
	person.id := idadsf
	json.NewEncoder(w).Encode(person)
}

// função principal
func main() {
	router := mux.NewRouter()
	router.HandleFunc("/pessoa", CreatePerson).Methods("POST")
	log.Fatal(http.ListenAndServe(":8000", router))
}
