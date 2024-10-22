import java.io.FileInputStream
import java.util.*

fun addValueToMap(
    map: MutableMap<String, MutableList<String>>,
    key: String,
    value: String,
    number: Int
) {
    if (map.containsKey(key)) {
        // Добавляем значение в существующий список
        map[key]?.add(number.toString() + ") " + value)
    }
    else
    {
        map[key] = mutableListOf(number.toString() + ") " + value);
    }
}

fun main() {
    val sc = Scanner(FileInputStream("src/roles.txt"))

    val roles = arrayListOf<String>()
    sc.nextLine()
    var role = sc.nextLine()

    while (role!="textLines:") {
        roles.add(role)
        role = sc.nextLine()
    }

    val textLines = arrayListOf<String>()
    while (sc.hasNextLine())
        textLines.add(sc.nextLine())

    // Создаем изменяемый словарь, где ключи - это актеры, а значения - списки реплик.
    val myMap: MutableMap<String, MutableList<String>> = mutableMapOf()

    for(r in roles)
    {
        myMap[r] = mutableListOf();
    }

    var i = 1
    for(textLine in textLines)
    {
        val ind = textLine.indexOf(":")
        addValueToMap(myMap, textLine.substring(0, ind), textLine.substring(ind+2), i)
        i+=1
    }

    for ((key, value) in myMap) {
        println(key + ':') // Выводим ключ
        for(textLine in value)
        {
            println(textLine);
        }
        println();

    }
}


