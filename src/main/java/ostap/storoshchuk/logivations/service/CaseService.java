package ostap.storoshchuk.logivations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ostap.storoshchuk.logivations.entity.Case;
import ostap.storoshchuk.logivations.entity.Orderline;
import ostap.storoshchuk.logivations.entity.SizeComparator;
import ostap.storoshchuk.logivations.repository.CaseRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CaseService {

    @Autowired
    private CaseRepository caseRepository;

    public void create(Case c) {
        if (c != null) {
            caseRepository.save(c);
        }
    }

    private Case temp(List<Orderline> orderlines, List<Case> cases) {
        Case c = null;
        for (int j = 0; j < orderlines.size(); j++) {
            for (int i = 0; i < cases.size(); i++) {
                if (cases.get(i).freeSpaceInPercent(orderlines.get(j)) >= 0) {
                    c = cases.get(i);
                }
            }
        }
        return c;
    }

    public Case theBestOrderline(List<Case> cases, List<Orderline> orderline) {
        cases.sort(new SizeComparator());
        System.out.println(cases);
        Case temp = temp(orderline, cases);
        for (Case c : cases
        ) {
            System.out.println(c.canContain(orderline.get(0).getProduct()));
            System.out.println("freeSpace= " + c.freeSpaceInPercent(orderline.get(0)) + " %");
        }


        for (int i = 0; i < orderline.size(); i++) {
            for (int j = 0; j < cases.size(); j++) {
                if (cases.get(j).freeSpaceInPercent(orderline.get(i)) < temp.freeSpaceInPercent(orderline.get(i))
                        && cases.get(j).freeSpaceInPercent(orderline.get(i)) > 0) {
                    temp = cases.get(j);
                }
            }
        }
        System.out.println(temp);
        return temp;
    }

    public List<Case> findAll() {
        return caseRepository.findAll();
    }
}
