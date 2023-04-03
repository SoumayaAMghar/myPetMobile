import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyanimalComponent } from './myanimal.component';

describe('MyanimalComponent', () => {
  let component: MyanimalComponent;
  let fixture: ComponentFixture<MyanimalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyanimalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyanimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
