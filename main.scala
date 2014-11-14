import PhillsGroupCalendar.GroupCalendar;

object main {

    def main(args :Array[String]) {

        if (args.length() == 0) {
            println("usage: ./query <list> <of> <usernames>");
            exit(0);
        }

        val groupCalendar = new GroupCalendar(args);
        val todaysAppointments = groupCalendar.retrieveTodaysCombinedList();

        println("working");

    }
}
