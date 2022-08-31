using Data.Enums;
using Data.Models;

namespace Registry.Core.Tests;

public class RegistryFixture
{
    public Office CreateOfficeEmployee() =>
        new()
        {
            FirstName = "Josh",
            LastName = "Agent",
            Age = 31,
            YearsOfExperience = 12,
            BadgeNumber = 1337123321,
            Iq = 150,
            Address = new()
            {
                Street = "Grunwaldzka",
                BuildingNumber = "5",
                FlatNumber = null,
                City = "Kwidzyn",
            }
        };

    public Physical CreatePhysicalEmployee() =>
        new()
        {
            FirstName = "Jack",
            LastName = "Szalala",
            Age = 35,
            YearsOfExperience = 3,
            Strength = 80,
            Address = new()
            {
                Street = "Warszawska",
                BuildingNumber = "12",
                FlatNumber = null,
                City = "Sztum",
            }
        };

    public Trader CreateTraderEmployee() =>
        new()
        {
            FirstName = "James",
            LastName = "xPompa",
            Age = 37,
            YearsOfExperience = 3,
            Efectiveness = EfectivenessType.Low,
            Commission = 1,
            Address = new()
            {
                Street = "Grudzi¹dzka",
                BuildingNumber = "63A",
                FlatNumber = "1",
                City = "Malbork",
            }
        };
}