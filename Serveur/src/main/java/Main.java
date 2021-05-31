import model.Personne;
import utils.DatabaseMigration;

import java.util.Date;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        DatabaseMigration.migrate();

        List<Personne> personneList = Personne.readAll();
        for(Personne p : personneList)
        {
            System.out.println(p.toString());
        }

        System.out.println(Personne.readPersonne("MikeRoss"));

        Personne.createPersonne("Junck", "Kevin", "KevinJunck", "123456", "kevin.junck@gmail.com", new Date(2000, 0, 1));
        System.out.println(Personne.readPersonne("KevinJunck"));

        Personne.updatePersonne(9, "Junck", "Kevin", "KevinJunck42", "reofbzwtg", "kevin.junck@gmail.com", new Date(2000, 0, 1));
        System.out.println(Personne.readPersonne("KevinJunck42"));

        Personne.deletePersonne(9);
        System.out.println(Personne.readPersonne("KevinJunck42"));
    }
}
