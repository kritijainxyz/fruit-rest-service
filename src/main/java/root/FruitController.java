package root;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class FruitController {
    List<Fruit> list= new ArrayList<Fruit>();


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = GET)
   /* public Fruit greeting( Fruit obj) {
        *//*return new Fruit(counter.incrementAndGet(),
                            obj.getName(), obj.getUrl());*//*

    }*/
    public Fruit greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Fruit(counter.incrementAndGet(),
                String.format(template, name), "tempurl");
    }

    @ResponseBody @RequestMapping(value = "/insert", consumes= {"application/json"}, produces= {"application/json"}, method= {RequestMethod.POST})
    public List<Fruit> insert(@RequestBody Fruit obj){
        obj.setId(counter.incrementAndGet());
        list.add(obj);
        return list;
    }

    @ResponseBody @RequestMapping(value = "/getAll", produces= {"application/json"}, method= {RequestMethod.GET})
    public List<Fruit> getAll(){
        return list;
    }

    @ResponseBody @RequestMapping(value = "/delete", consumes= {"application/json"}, produces= {"application/json"}, method= {RequestMethod.DELETE})
    public List<Fruit> delete(@RequestBody Fruit obj){
        for(Fruit x: list){
            if(x.getId()==obj.getId()){
                list.remove(x);
            }
        }
        return list;
    }

    @ResponseBody @RequestMapping(value = "/update", consumes= {"application/json"}, produces= {"application/json"}, method= {RequestMethod.PUT})
    public List<Fruit> update(@RequestBody Fruit[] obj){
        for(Fruit x: list){
            if(x.getId()==obj[0].getId()){
                list.set(list.indexOf(x), obj[1]);
            }
        }
        return list;
    }
}
