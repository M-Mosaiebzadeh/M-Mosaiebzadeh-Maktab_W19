class Person {
    constructor(firstName, lastName, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}

class Store {
    static getPersonList() {
        let list = localStorage.getItem("personList");
        if (localStorage.getItem("personList") === null) {
            list = [];
        } else {
            list = JSON.parse(localStorage.getItem("personList"));
        }
        return list;
    }

    static addPerson(person) {
        let list = Store.getPersonList();
        list.push(person);
        localStorage.setItem("personList", JSON.stringify(list));
    }

    static removePerson(firstName) {
        let list = Store.getPersonList();
        list.forEach((item, index) => {
            if (item.firstName === firstName) {
                list.splice(index, 1);
            }
        });
        localStorage.setItem("personList", JSON.stringify(list));
    }
}

class UI {
    static display() {
        const result = Store.getPersonList();

        const personList = result;
        personList.forEach((el) => {
            UI.addPersonToList(el);
        });
    }

    static addPersonToList(person) {
        const personList = document.getElementsByClassName("person-list")[0];

        const row = document.createElement("tr");
        row.innerHTML = `
      <td>${person.firstName}</td>
      <td>${person.lastName}</td>
      <td>${person.email}</td>
      <td><a class="delete" href="#"><i class="fas fa-user-times"></i></a></td>
    `;
        personList.appendChild(row);
    }

    static deletePerson(el) {
        if (el.classList.contains("fas")) {
            el.parentElement.parentElement.parentElement.remove();
        }
    }

    static showAlertMessage(message, className) {
        const person = document.getElementsByClassName("person")[0];
        const form = document.getElementsByClassName("person-form")[0];
        const div = document.createElement("div");
        div.className = `alert alert-${className}`;
        div.appendChild(document.createTextNode(message));
        person.insertBefore(div, form);

        setTimeout(() => {
            person.removeChild(div);
        }, 3000);
    }

    static clearFields() {
        document.getElementById("first-name").value = "";
        document.getElementById("last-name").value = "";
        document.getElementById("email").value = "";
    }
}

document.addEventListener("DOMContentLoaded", () => {
    UI.display();
});

document
    .getElementsByClassName("person-form")[0]
    .addEventListener("submit", (e) => {
        e.preventDefault();
        const firstName = document.getElementById("first-name").value;
        const lastName = document.getElementById("last-name").value;
        const email = document.getElementById("email").value;

        if (firstName === "" || lastName === "" || email === "") {
            UI.showAlertMessage("The fields should not be empty", "danger");
        } else {
            let person = new Person(firstName, lastName, email);
            UI.addPersonToList(person);
            Store.addPerson(person);
            UI.showAlertMessage("Person added success", "success");
            UI.clearFields();
        }
    });

document
    .getElementsByClassName("person-list")[0]
    .addEventListener("click", (e) => {
        e.preventDefault();
        UI.deletePerson(e.target);
        const firstName =
            e.target.parentElement.parentElement.parentElement.children[0].innerHTML;
        Store.removePerson(firstName);
        UI.showAlertMessage("Person removed success", "success");
    });