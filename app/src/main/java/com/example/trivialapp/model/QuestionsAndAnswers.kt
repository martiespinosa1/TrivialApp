package com.example.trivialapp.model

class QuestionsAndAnswers {
    data class Kahoot(
        val pregunta: String,
        val respuesta1: String,
        val respuesta2: String,
        val respuesta3: String
    )

    val preguntasEasy = arrayOf(
        Kahoot(
            pregunta = "¿Cuál es el color primario?",
            respuesta1 = "Rojo",
            respuesta2 = "Verde",
            respuesta3 = "Azul"
        ),
        Kahoot(
            pregunta = "¿Cuál es el animal más grande del mundo?",
            respuesta1 = "Elefante",
            respuesta2 = "Ballena Azul",
            respuesta3 = "Jirafa"
        ),
        Kahoot(
            pregunta = "¿Cuál es el continente más poblado?",
            respuesta1 = "Asia",
            respuesta2 = "África",
            respuesta3 = "Europa"
        ),
        Kahoot(
            pregunta = "¿Cuál es el planeta más cercano al Sol?",
            respuesta1 = "Venus",
            respuesta2 = "Mercurio",
            respuesta3 = "Marte"
        ),
        Kahoot(
            pregunta = "¿Cuál es el océano más grande?",
            respuesta1 = "Atlántico",
            respuesta2 = "Pacífico",
            respuesta3 = "Índico"
        ),
        Kahoot(
            pregunta = "¿Cuál es el país más grande del mundo?",
            respuesta1 = "Rusia",
            respuesta2 = "China",
            respuesta3 = "Estados Unidos"
        ),
        Kahoot(
            pregunta = "¿Cuál es el instrumento musical más antiguo?",
            respuesta1 = "Flauta",
            respuesta2 = "Piano",
            respuesta3 = "Violín"
        ),
        Kahoot(
            pregunta = "¿Cuál es el idioma más hablado del mundo?",
            respuesta1 = "Inglés",
            respuesta2 = "Español",
            respuesta3 = "Mandarín"
        ),
        Kahoot(
            pregunta = "¿Cuál es el deporte más popular del mundo?",
            respuesta1 = "Fútbol",
            respuesta2 = "Baloncesto",
            respuesta3 = "Tenis"
        ),
        Kahoot(
            pregunta = "¿Cuál es el país con forma de bota?",
            respuesta1 = "Italia",
            respuesta2 = "España",
            respuesta3 = "México"
        ),
        Kahoot(
            pregunta = "¿Cuál es el río más largo del mundo?",
            respuesta1 = "Nilo",
            respuesta2 = "Amazonas",
            respuesta3 = "Mississippi"
        ),
        Kahoot(
            pregunta = "¿Cuál es el animal nacional de Australia?",
            respuesta1 = "Canguro",
            respuesta2 = "Koala",
            respuesta3 = "Emú"
        ),
        Kahoot(
            pregunta = "¿Cuál es el símbolo químico del oro?",
            respuesta1 = "Ag",
            respuesta2 = "Au",
            respuesta3 = "Fe"
        ),
        Kahoot(
            pregunta = "¿Cuál es el país conocido como la cuna de la civilización?",
            respuesta1 = "Egipto",
            respuesta2 = "Grecia",
            respuesta3 = "Irak"
        ),
        Kahoot(
            pregunta = "¿Cuál es el número de lados de un triángulo?",
            respuesta1 = "3",
            respuesta2 = "4",
            respuesta3 = "5"
        )
    )



    val preguntasMedium = arrayOf(
        Kahoot(
            pregunta = "¿Cuál es la capital de Australia?",
            respuesta1 = "Sídney",
            respuesta2 = "Melbourne",
            respuesta3 = "Canberra"
        ),
        Kahoot(
            pregunta = "¿Quién escribió la novela 'Cien años de soledad'?",
            respuesta1 = "Gabriel García Márquez",
            respuesta2 = "Mario Vargas Llosa",
            respuesta3 = "Jorge Luis Borges"
        ),
        Kahoot(
            pregunta = "¿Cuál es el río más largo de África?",
            respuesta1 = "Nilo",
            respuesta2 = "Congo",
            respuesta3 = "Zambeze"
        ),
        Kahoot(
            pregunta = "¿Cuál es el elemento químico más abundante en la Tierra?",
            respuesta1 = "Oxígeno",
            respuesta2 = "Carbono",
            respuesta3 = "Hierro"
        ),
        Kahoot(
            pregunta = "¿Cuál es el país más poblado del mundo?",
            respuesta1 = "China",
            respuesta2 = "India",
            respuesta3 = "Estados Unidos"
        ),
        Kahoot(
            pregunta = "¿Cuál es el autor de la obra 'Don Quijote de la Mancha'?",
            respuesta1 = "Miguel de Cervantes",
            respuesta2 = "Federico García Lorca",
            respuesta3 = "Pablo Neruda"
        ),
        Kahoot(
            pregunta = "¿Cuál es el océano más grande del mundo?",
            respuesta1 = "Pacífico",
            respuesta2 = "Atlántico",
            respuesta3 = "Índico"
        ),
        Kahoot(
            pregunta = "¿Cuál es el monte más alto del mundo?",
            respuesta1 = "Monte Everest",
            respuesta2 = "Monte Kilimanjaro",
            respuesta3 = "Monte Aconcagua"
        ),
        Kahoot(
            pregunta = "¿Cuál es el símbolo químico del oro?",
            respuesta1 = "Au",
            respuesta2 = "Ag",
            respuesta3 = "Fe"
        ),
        Kahoot(
            pregunta = "¿Cuál es el país conocido como 'la tierra del sol naciente'?",
            respuesta1 = "Japón",
            respuesta2 = "China",
            respuesta3 = "Corea del Sur"
        ),
        Kahoot(
            pregunta = "¿Cuál es el autor de la obra 'Romeo y Julieta'?",
            respuesta1 = "William Shakespeare",
            respuesta2 = "Friedrich Nietzsche",
            respuesta3 = "Charles Dickens"
        ),
        Kahoot(
            pregunta = "¿Cuál es el río más largo de Europa?",
            respuesta1 = "Volga",
            respuesta2 = "Danubio",
            respuesta3 = "Rin"
        ),
        Kahoot(
            pregunta = "¿Cuál es el país conocido como 'la tierra de los faraones'?",
            respuesta1 = "Egipto",
            respuesta2 = "Grecia",
            respuesta3 = "Italia"
        ),
        Kahoot(
            pregunta = "¿Cuál es el autor de la obra '1984'?",
            respuesta1 = "George Orwell",
            respuesta2 = "Aldous Huxley",
            respuesta3 = "Ray Bradbury"
        ),
        Kahoot(
            pregunta = "¿Cuál es el continente más grande del mundo?",
            respuesta1 = "Asia",
            respuesta2 = "África",
            respuesta3 = "América"
        )
    )



    val preguntasHard = arrayOf(
        Kahoot(
            pregunta = "¿Cuál es el país más extenso del mundo?",
            respuesta1 = "Rusia",
            respuesta2 = "Canadá",
            respuesta3 = "China"
        ),
        Kahoot(
            pregunta = "¿Quién pintó el cuadro 'La noche estrellada'?",
            respuesta1 = "Vincent van Gogh",
            respuesta2 = "Pablo Picasso",
            respuesta3 = "Leonardo da Vinci"
        ),
        Kahoot(
            pregunta = "¿Cuál es el libro más vendido de la historia?",
            respuesta1 = "La Biblia",
            respuesta2 = "Don Quijote de la Mancha",
            respuesta3 = "El Principito"
        ),
        Kahoot(
            pregunta = "¿Cuál es el país con más premios Nobel?",
            respuesta1 = "Estados Unidos",
            respuesta2 = "Reino Unido",
            respuesta3 = "Alemania"
        ),
        Kahoot(
            pregunta = "¿Cuál es el monumento más visitado del mundo?",
            respuesta1 = "La Gran Muralla China",
            respuesta2 = "La Torre Eiffel",
            respuesta3 = "El Coliseo Romano"
        ),
        Kahoot(
            pregunta = "¿Cuál es el compositor de la Sinfonía No. 9 'Coral'?",
            respuesta1 = "Ludwig van Beethoven",
            respuesta2 = "Wolfgang Amadeus Mozart",
            respuesta3 = "Johann Sebastian Bach"
        ),
        Kahoot(
            pregunta = "¿Cuál es el país con más islas en el mundo?",
            respuesta1 = "Suecia",
            respuesta2 = "Filipinas",
            respuesta3 = "Indonesia"
        ),
        Kahoot(
            pregunta = "¿Cuál es el autor de la obra 'Guerra y Paz'?",
            respuesta1 = "León Tolstói",
            respuesta2 = "Fyodor Dostoyevsky",
            respuesta3 = "Anton Chekhov"
        ),
        Kahoot(
            pregunta = "¿Cuál es el animal más rápido del mundo?",
            respuesta1 = "Guepardo",
            respuesta2 = "Leopardo",
            respuesta3 = "León"
        ),
        Kahoot(
            pregunta = "¿Cuál es el pintor del cuadro 'La última cena'?",
            respuesta1 = "Leonardo da Vinci",
            respuesta2 = "Pablo Picasso",
            respuesta3 = "Vincent van Gogh"
        )
    )




}