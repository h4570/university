using Data.Models;

namespace Registry.Core.Tests;

public class RegistryTests
{
    private Registry Registry;
    private RegistryFixture Fixture;

    [SetUp]
    public void Setup()
    {
        Registry = new Registry();
        Fixture = new RegistryFixture();
    }

    [Test]
    public void AddSingleOffice_ResultListShouldContainsSingleElement()
    {
        var office = Fixture.CreateOfficeEmployee();

        Registry.Add(office);

        Assert.Multiple(() =>
        {
            Assert.That(office.Id, Is.EqualTo(1));
            Assert.That(Registry.GetAllSorted().Count(), Is.EqualTo(1));
        });
    }

    [Test]
    public void AddTwoEmployees_ResultListShouldContainsTwoElements()
    {
        var office = Fixture.CreateOfficeEmployee();
        var physical = Fixture.CreateOfficeEmployee();

        Registry.AddRange(new List<Employee> { office, physical });

        Assert.Multiple(() =>
        {
            Assert.That(office.Id, Is.EqualTo(1));
            Assert.That(physical.Id, Is.EqualTo(2));
            Assert.That(Registry.GetAllSorted().Count(), Is.EqualTo(2));
        });
    }

    [Test]
    public void AddThreeEmployees_ResultListShouldContainsThreeElements()
    {
        var office = Fixture.CreateOfficeEmployee();
        var physical = Fixture.CreateOfficeEmployee();
        var trader = Fixture.CreateTraderEmployee();

        Registry.AddRange(new List<Employee> { office, physical, trader });

        Assert.Multiple(() =>
        {
            Assert.That(office.Id, Is.EqualTo(1));
            Assert.That(physical.Id, Is.EqualTo(2));
            Assert.That(trader.Id, Is.EqualTo(3));
            Assert.That(Registry.GetAllSorted().Count(), Is.EqualTo(3));
        });
    }

    [Test]
    public void AddTwoEmployeesAndDeleteSingle_ResultListShouldContainsSingleElement()
    {
        var office = Fixture.CreateOfficeEmployee();
        var trader = Fixture.CreateTraderEmployee();

        Registry.AddRange(new List<Employee> { office, trader });
        Registry.RemoveOfficeByBadge(office.BadgeNumber);

        var all = Registry.GetAllSorted().ToList();
        Assert.Multiple(() =>
        {
            Assert.That(all, Has.Count.EqualTo(1));
            Assert.That(all.First().Id, Is.EqualTo(2));
        });
    }

    [Test]
    public void AddThreeEmployeesAndDeleteSingle_ResultListShouldContainsTwoElements()
    {
        var office = Fixture.CreateOfficeEmployee();
        var trader = Fixture.CreateTraderEmployee();
        var physical = Fixture.CreatePhysicalEmployee();

        Registry.AddRange(new List<Employee> { office, trader, physical });
        Registry.RemoveOfficeByBadge(office.BadgeNumber);

        var all = Registry.GetAllSorted().ToList();
        Assert.Multiple(() =>
        {
            Assert.That(all, Has.Count.EqualTo(2));
            Assert.That(all.First().Id, Is.EqualTo(3));
            Assert.That(all.Last().Id, Is.EqualTo(2));
        });
    }

    [Test]
    public void AddTwoEmployeesWithDifferentCity_ResultListShouldContainsSingleElement1()
    {
        var office = Fixture.CreateOfficeEmployee();
        var trader = Fixture.CreateTraderEmployee();

        Registry.AddRange(new List<Employee> { office, trader });

        var all = Registry.GetByCity("Kwidzyn").ToList();
        Assert.Multiple(() =>
        {
            Assert.That(all, Has.Count.EqualTo(1));
            Assert.That(all.First().Id, Is.EqualTo(1));
        });
    }

    [Test]
    public void AddTwoEmployeesWithDifferentCity_ResultListShouldContainsSingleElement2()
    {
        var office = Fixture.CreateOfficeEmployee();
        var trader = Fixture.CreateTraderEmployee();

        Registry.AddRange(new List<Employee> { office, trader });

        var all = Registry.GetByCity("Malbork").ToList();
        Assert.Multiple(() =>
        {
            Assert.That(all, Has.Count.EqualTo(1));
            Assert.That(all.First().Id, Is.EqualTo(2));
        });
    }

    [Test]
    public void AddThreeEmployees_SortedResultShouldBeCorrect()
    {
        var office = Fixture.CreateOfficeEmployee();
        var trader = Fixture.CreateTraderEmployee();
        var physical = Fixture.CreatePhysicalEmployee();

        Registry.AddRange(new List<Employee> { office, trader, physical });

        var all = Registry.GetAllSorted().ToList();
        Assert.Multiple(() =>
        {
            Assert.That(all, Has.Count.EqualTo(3));

            Assert.That(all[0].YearsOfExperience, Is.EqualTo(12));

            Assert.That(all[1].YearsOfExperience, Is.EqualTo(3));
            Assert.That(all[1].Age, Is.EqualTo(35));

            Assert.That(all[2].YearsOfExperience, Is.EqualTo(3));
            Assert.That(all[2].Age, Is.EqualTo(37));
        });
    }

    [Test]
    public void AddThreeEmployees_CheckCompany()
    {
        var office = Fixture.CreateOfficeEmployee();
        var trader = Fixture.CreateTraderEmployee();
        var physical = Fixture.CreatePhysicalEmployee();

        Registry.AddRange(new List<Employee> { office, trader, physical });

        var list = Registry.GetValued().ToList();

        var officeValue = list.Single(c => c.Employee.Id == office.Id).Value;
        var traderValue = list.Single(c => c.Employee.Id == trader.Id).Value;
        var physicalValue = list.Single(c => c.Employee.Id == physical.Id).Value;

        Assert.Multiple(() =>
        {
            Assert.That(list, Has.Count.EqualTo(3));

            Assert.That(officeValue, Is.EqualTo(1800));
            Assert.That(traderValue, Is.EqualTo(180));
            Assert.That(physicalValue, Is.EqualTo(6));
        });
    }
}