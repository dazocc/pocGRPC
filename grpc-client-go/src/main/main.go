package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"time"
)

type Person struct {
	id    int    `json:"id,omitempty"`
	nome  string `json:"firstname,omitempty"`
	login string `json:"lastname,omitempty"`
	cpf   string `json:"lastname,omitempty"`
	email string `json:"lastname,omitempty"`
}

func NewPerson(nome string, login string, cpf string, email string) *Person {
	p := new(Person)
	p.nome = nome
	p.login = login
	p.cpf = cpf
	p.email = email
	return p
}

func post() {
	var exec = 10000

	start := time.Now()

	personRequest := NewPerson(
		"Davison Oliveira",
		"davison.oliveira",
		"344.725.450-55",
		"davison.oliveira@gmail.com")

	jsonReq, err := json.Marshal(personRequest)

	if err != nil {
		return
	}

	for i := 0; i < exec; i++ {
		resp, err := http.Post("http://localhost:8000/pessoa", "application/json; charset=utf-8", bytes.NewBuffer(jsonReq))
		if err != nil {
			return
		}
		defer resp.Body.Close()
		bodyBytes, _ := ioutil.ReadAll(resp.Body)
		var personResponse Person
		json.Unmarshal(bodyBytes, &personResponse)
		fmt.Println(personResponse.id)
		fmt.Println(i)
	}

	fmt.Println(time.Since(start))

}

func main() {
	post()
}
