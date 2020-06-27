import { Component, OnInit } from '@angular/core';
import { StocksService } from '../stocks.service';

import {ButtonModule} from 'primeng/button';
import {PaginatorModule} from 'primeng/paginator';

@Component({
  selector: 'app-stocks-listing',
  templateUrl: './stocks-listing.component.html',
  styleUrls: ['./stocks-listing.component.css']
})
export class StocksListingComponent implements OnInit {

  stocks : Array<any>;
  constructor(private stockservice: StocksService) { }

  ngOnInit(): void {
  }
  
  list(){
    this.stockservice.list().subscribe(dados => this.stocks = dados);
  }
}
