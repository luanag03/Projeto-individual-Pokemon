document.addEventListener("DOMContentLoaded", async function () {
    const selectPokemon = document.getElementById("pokemon");

    try {
        const resposta = await fetch("http://localhost:8080/pokemons");
        
        if (resposta.ok) {
            const pokemons = await resposta.json();

            for (let i = 0; i < pokemons.length; i++) {
                const option = document.createElement("option");
                option.value = pokemons[i].nome;
                option.textContent = `${pokemons[i].nome} (${pokemons[i].tipo})`;
                selectPokemon.appendChild(option);
            }
        }
    } catch (erro) {
        console.error("Erro ao carregar os pokémons:", erro);
    }
});

const formCadastro = document.getElementById("formCadastro");

formCadastro.addEventListener("submit", async function (evento) {
    evento.preventDefault();

    const tiposCheckbox = document.getElementsByName('tipo');
    let tiposFavoritosArray = [];

    for (let i = 0; i < tiposCheckbox.length; i++) {
        if (tiposCheckbox[i].checked) {
            tiposFavoritosArray.push(tiposCheckbox[i].value);
        }
    }

    const sexoSelecionado = document.querySelector('input[name="sexo"]:checked');

    const novoUsuario = {
        nome: document.getElementById("nome").value,
        nickname: document.getElementById("nickname").value,
        email: document.getElementById("email").value,
        idade: Number(document.getElementById("idade").value),
        dataNascimento: document.getElementById("dataNascimento").value,
        sexo: sexoSelecionado ? sexoSelecionado.value : "",
        tiposFavoritos: tiposFavoritosArray.join(","),
        pokemonInicial: document.getElementById("pokemon").value,
        senha: document.getElementById("senha").value
    };

    try {
        const resposta = await fetch("http://localhost:8080/usuarios/cadastrar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(novoUsuario)
        });

        if (resposta.status === 201) {
            alert("Jornada iniciada com sucesso! Faça login.");
            window.location.href = "login.html";
        } else {
            alert("Erro ao realizar o cadastro. Verifique os dados.");
        }
    } catch (erro) {
        console.error("Erro na requisição:", erro);
        alert("Não foi possível conectar ao servidor.");
    }
});