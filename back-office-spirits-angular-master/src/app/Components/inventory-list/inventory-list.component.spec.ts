import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { ProductPipe } from 'src/app/Pipes/product.pipe';
import { InventoryService } from 'src/app/Services/Inventory/inventory.service';

import { InventoryListComponent } from './inventory-list.component';

describe('InventoryListComponent', () => {
  let component: InventoryListComponent;
  let fixture: ComponentFixture<InventoryListComponent>;

  let inventoryService: InventoryService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InventoryListComponent , ProductPipe],
      imports: [HttpClientModule],
      providers: [ InventoryService]
    })
    .compileComponents();

    inventoryService = TestBed.get(InventoryService)
    spyOn(inventoryService, 'getAllProducts').and.returnValue(of(''));

  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('ngOnInit Exists', () => {
    expect(component.ngOnInit).toBeTruthy();
  });


  it('ngOnInit should call Inventory Service to get all products', () => {
    component.ngOnInit()
    expect(inventoryService.getAllProducts).toHaveBeenCalled();
  });


});
