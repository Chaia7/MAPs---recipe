document.getElementById('new-recipe-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Capturar os valores dos campos do formulário
    const title = document.getElementById('recipe-title').value;
    const ingredients = document.getElementById('recipe-ingredients').value;
    const instructions = document.getElementById('recipe-instructions').value;
    const image = document.getElementById('recipe-image').files[0];

    // Criar um novo elemento de lista para a receita
    const recipeItem = document.createElement('li');
    recipeItem.innerHTML = `
        <h3>${title}</h3>
        <p><strong>Ingredientes:</strong></p>
        <p>${ingredients}</p>
        <p><strong>Instruções:</strong></p>
        <p>${instructions}</p>
        <button class="delete-btn">Excluir</button>
    `;

    // Adicionar evento de exclusão para o botão "Excluir"
    recipeItem.querySelector('.delete-btn').addEventListener('click', function() {
        recipeItem.remove();
    });

    // Adicionar imagem se fornecida
    if (image) {
        const reader = new FileReader();
        reader.onload = function(event) {
            const img = document.createElement('img');
            img.src = event.target.result;
            recipeItem.appendChild(img);
        };
        reader.readAsDataURL(image);
    }

    // Adicionar o novo item à lista de receitas
    document.getElementById('recipes').appendChild(recipeItem);

    // Limpar o formulário
    document.getElementById('new-recipe-form').reset();
});
