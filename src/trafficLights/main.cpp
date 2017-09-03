#include <chrono>
#include <thread>
#include <iostream>
#include <assert.h>

enum class Light
{
    Off = 0,
    Red,
    Amber,
    Green
};

inline std::ostream& operator << (std::ostream& ostrm, const Light& light)
{
    if (light == Light::Off)
    {
        ostrm << "OFF";
    }
    else if (light == Light::Red)
    {
        ostrm << "RED";
    }
    else if (light == Light::Amber)
    {
        ostrm << "AMBER";
    }
    else if (light == Light::Green)
    {
        ostrm << "GREEN";
    }

    return ostrm;
}


class TrafficLight
{
public:
    TrafficLight() :
        _light(Light::Off)
    {}

    void setLight(Light light)
    {
        _light = light;
    }

    Light getLight() const
    {
        return _light;
    }

private:
    Light _light;
};


class Controller
{
public:
    Controller() :
        _amberDuration(30),
        _lightDuration(5)
    {}

    const TrafficLight& getNTrafficLight() const
    {
        return _nTrafficLight;
    }

    const TrafficLight& getSTrafficLight() const
    {
        return _sTrafficLight;
    }

    const TrafficLight& getETrafficLight() const
    {
        return _eTrafficLight;
    }

    const TrafficLight& getWTrafficLight() const
    {
        return _wTrafficLight;
    }

    std::chrono::seconds getAmberDuration() const
    {
        return _amberDuration;
    }

    std::chrono::minutes getLightDuration() const
    {
        return _lightDuration;
    }

    std::chrono::seconds cycleDuration() const
    {
        return _lightDuration + _lightDuration;
    }

    void updateLights(std::chrono::seconds currentTime)
    {
        if (currentTime < std::chrono::seconds(0))
        {
            throw std::invalid_argument("invalid currentTime");
        }

        std::chrono::seconds inCycleTime = currentTime % cycleDuration();

        if (inCycleTime < _lightDuration)
        {
            if (inCycleTime >= _lightDuration - _amberDuration && 
                inCycleTime < _lightDuration)
            {
                _nTrafficLight.setLight(Light::Amber);
                _sTrafficLight.setLight(Light::Amber);
            }
            else
            {
                _nTrafficLight.setLight(Light::Green);
                _sTrafficLight.setLight(Light::Green);
            }

            _eTrafficLight.setLight(Light::Red);
            _wTrafficLight.setLight(Light::Red);
        }
        else
        {
            if (inCycleTime >= cycleDuration() - _amberDuration && 
                inCycleTime < cycleDuration())
            {
                _eTrafficLight.setLight(Light::Amber);
                _wTrafficLight.setLight(Light::Amber);
            }
            else
            {
                _eTrafficLight.setLight(Light::Green);
                _wTrafficLight.setLight(Light::Green);
            }

            _nTrafficLight.setLight(Light::Red);
            _sTrafficLight.setLight(Light::Red);
        }
    }

private:
    TrafficLight _nTrafficLight;
    TrafficLight _sTrafficLight;

    TrafficLight _eTrafficLight;
    TrafficLight _wTrafficLight;

    const std::chrono::seconds _amberDuration;

    const std::chrono::minutes _lightDuration;
};


int main(int argc, char *argv[])
{
    {
        std::cout << "testing..." << std::endl;

        Controller controller;

        controller.updateLights(std::chrono::seconds(0));

        assert(controller.getNTrafficLight().getLight() == controller.getSTrafficLight().getLight());
        assert(controller.getETrafficLight().getLight() == controller.getWTrafficLight().getLight());

        assert(controller.getNTrafficLight().getLight() != controller.getWTrafficLight().getLight());

        assert(controller.getNTrafficLight().getLight() == Light::Green);
        assert(controller.getWTrafficLight().getLight() == Light::Red);

        controller.updateLights(
                controller.getLightDuration() - controller.getAmberDuration() + std::chrono::seconds(0));

        assert(controller.getNTrafficLight().getLight() == Light::Amber);
        assert(controller.getWTrafficLight().getLight() == Light::Red);

        controller.updateLights(
                controller.getLightDuration() + std::chrono::seconds(0));

        assert(controller.getNTrafficLight().getLight() == Light::Red);
        assert(controller.getWTrafficLight().getLight() == Light::Green);

        controller.updateLights(
                controller.cycleDuration() - controller.getAmberDuration() + std::chrono::seconds(0));

        assert(controller.getNTrafficLight().getLight() == Light::Red);
        assert(controller.getWTrafficLight().getLight() == Light::Amber);

        controller.updateLights(
                controller.cycleDuration() + std::chrono::seconds(0));

        assert(controller.getNTrafficLight().getLight() == Light::Green);
        assert(controller.getWTrafficLight().getLight() == Light::Red);

        std::cout << "good." << std::endl;
    }

    {
        std::cout << "simulation..." << std::endl;

        Controller controller;

        const std::chrono::minutes simulationDuration(30);

        auto simulationStart = std::chrono::system_clock::now();

        std::chrono::seconds lastUpdateTime(-1);

        while (true)
        {
            std::chrono::time_point<std::chrono::system_clock> nowTimePoint = std::chrono::system_clock::now();

            std::chrono::seconds currentTime = 
                std::chrono::duration_cast<std::chrono::seconds>(nowTimePoint - simulationStart);

            if (currentTime > simulationDuration)
            {
               break;
            }

            if (lastUpdateTime < currentTime)
            {
                lastUpdateTime = currentTime;
                
                controller.updateLights(currentTime);

                 std::cout 
                     << " time (sec): " << currentTime.count() 
                     << " N:" << controller.getNTrafficLight().getLight()
                     << " S:" << controller.getSTrafficLight().getLight()
                     << " E:" << controller.getETrafficLight().getLight()
                     << " W:" << controller.getWTrafficLight().getLight()
                     << std::endl;
            }

            std::this_thread::sleep_for(std::chrono::seconds(1));
        }
    }

    return 0;
}


